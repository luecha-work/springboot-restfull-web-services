package luechawork.springbootrestfullwebservices.exception;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
