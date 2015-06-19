
package poslovnaxws.services.banka;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-19T00:21:24.507+02:00
 * Generated source version: 2.6.5
 */

@WebFault(name = "status", targetNamespace = "PoslovnaXWS/Common")
public class NotificationMessage extends Exception {
    
    private poslovnaxws.common.Status status;

    public NotificationMessage() {
        super();
    }
    
    public NotificationMessage(String message) {
        super(message);
    }
    
    public NotificationMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationMessage(String message, poslovnaxws.common.Status status) {
        super(message);
        this.status = status;
    }

    public NotificationMessage(String message, poslovnaxws.common.Status status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public poslovnaxws.common.Status getFaultInfo() {
        return this.status;
    }
}
