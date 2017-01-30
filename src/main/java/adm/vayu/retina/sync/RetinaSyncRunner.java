package adm.vayu.retina.sync;

import adm.vayu.retina.sync.common.RetinaSyncException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class RetinaSyncRunner {

    private static final Logger _logger = LoggerFactory.getLogger(RetinaSyncRunner.class);
    private ReentrantLock _locker = new ReentrantLock();
    private RetinaSyncProperties _properties;
    private Thread _syncThread = null;
    private volatile boolean _stopped = false;

    @Autowired
    public RetinaSyncRunner(RetinaSyncProperties properties) {

        _properties = properties;
    }

    boolean start() {

        boolean ret = false;
        _logger.debug("Starting retina sync runner...");
        _locker.lock();
        try {
            if (_syncThread == null) {
                _syncThread = new Thread(this::doStart);
                _syncThread.start();
                ret = true;
            }
        } finally {
            _locker.unlock();
        }


        return ret;
    }

    void stop() {

        _logger.debug("Stopping retina sync runner...");
        _stopped = true;
        _locker.lock();
        try {
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
        } finally {
            _locker.unlock();
        }
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
}