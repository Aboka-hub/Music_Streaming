package cb.empty.music_streaming.exception;

import cb.empty.music_streaming.dto.response.NurtayAbylaikhanErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class NurtayAbylaikhanGlobalExceptionHandler {

    @ExceptionHandler(NurtayAbylaikhanNotFoundException.class)
    public ResponseEntity<NurtayAbylaikhanErrorResponse> handleNotFound(
            NurtayAbylaikhanNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new NurtayAbylaikhanErrorResponse(
                        404, ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NurtayAbylaikhanErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new NurtayAbylaikhanErrorResponse(
                        400, message, LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<NurtayAbylaikhanErrorResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new NurtayAbylaikhanErrorResponse(
                        500, ex.getMessage(), LocalDateTime.now()));
    }
}
