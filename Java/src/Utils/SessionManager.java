/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Oliveira
 */
public class SessionManager {
    private static final int INACTIVITY_TIMEOUT = 600000; // 10 minutos
    private static final int SESSION_TIMEOUT = 14400000;  // 4 horas
    private Timer sessionTimer;
    private long lastActivityTime;
    private long sessionStartTime;
    private boolean sessionActive;

    public SessionManager() {
        lastActivityTime = System.currentTimeMillis();
        sessionStartTime = lastActivityTime;
        sessionActive = true;
        startSessionTimer();
    }

    public void addUserActivityListeners() {
        AWTEventListener activityListener = e -> {
            if (e.getID() == MouseEvent.MOUSE_MOVED ||
                e.getID() == MouseEvent.MOUSE_CLICKED ||
                e.getID() == KeyEvent.KEY_PRESSED) {
                resetInactivityTimer();
            }
        };

        Toolkit.getDefaultToolkit().addAWTEventListener(
            activityListener,
            AWTEvent.MOUSE_EVENT_MASK | AWTEvent.KEY_EVENT_MASK
        );
    }

    private synchronized void startSessionTimer() {
        sessionTimer = new Timer();
        sessionTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();

                // Verifica inatividade
                if (currentTime - lastActivityTime > INACTIVITY_TIMEOUT) {
                    sessionActive = false;
                }

                // Verifica tempo total da sessão
                if (currentTime - sessionStartTime > SESSION_TIMEOUT) {
                    sessionActive = false;
                }
            }
        }, 5000, 5000); // Verifica a cada 5 segundos
    }

    private synchronized void resetInactivityTimer() {
        lastActivityTime = System.currentTimeMillis();
        if (!sessionActive) {
            sessionActive = true; // Reativa a sessão se estava inativa
        }
    }

    public synchronized boolean isSessionActive() {
        return sessionActive;
    }

    public synchronized void logout() {
        sessionActive = false;
        if (sessionTimer != null) {
            sessionTimer.cancel();
        }
    }
}

