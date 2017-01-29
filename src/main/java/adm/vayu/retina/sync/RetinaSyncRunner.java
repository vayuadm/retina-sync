package adm.vayu.retina.sync;

import adm.vayu.retina.sync.common.RetinaSyncException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetinaSyncRunner {

    private static final Logger _logger = LoggerFactory.getLogger(RetinaSyncRunner.class);

    @Autowired
    private RetinaSyncProperties _properties;
    private Thread _syncThread = null;
    private volatile boolean _stopped = false;

    public synchronized boolean start() {

        boolean ret = false;
        if (_syncThread == null) {
            _syncThread = new Thread(() -> doStart());
            _syncThread.start();
            ret = true;
        }

        return ret;
    }

    private void doStart() {

        while (!_stopped) {
            try {
                // TrelloSync.update(ALMSync.getEntities(getConnection()));
            } catch (Exception e) {
                _logger.error("Failed to update Trello", e);
            } finally {
                sleep();
            }
        }
    }

    private void sleep() {

        try {
            long sleepTime = _properties.getInterval();
            _logger.debug(String.format("Going to sleep %d minutes", sleepTime));
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            _logger.error("Retina sync thread interrupted while sleeping", e);
        }
    }

    public void stop() {

        _logger.debug("Stopping retina sync runner...");
        _stopped = true;
        if (_syncThread != null) {
            _syncThread.interrupt();
            try {
                final int STOP_TIMEOUT = 5000;
                _syncThread.join(STOP_TIMEOUT);
            } catch (InterruptedException e) {
                throw new RetinaSyncException(e);
            } finally {
                if (_syncThread.isAlive()) {
                    _logger.warn("Controller thread did not stopped");
                }
                _syncThread = null;
            }
        }
    }
}