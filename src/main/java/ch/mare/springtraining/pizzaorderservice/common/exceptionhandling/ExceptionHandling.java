package ch.mare.springtraining.pizzaorderservice.common.exceptionhandling;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ProblemDto> handleResourceNotFoundException() {

    ProblemDto problem = new ProblemDto(NOT_FOUND.getReasonPhrase(), NOT_FOUND.value(), "The requested resource is not available");

    return ResponseEntity.status(NOT_FOUND).body(problem);
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<ProblemDto> handleApplicationException(ApplicationException exception) {

    ProblemDto problem = new ProblemDto(BAD_REQUEST.getReasonPhrase(), BAD_REQUEST.value(), exception.getProblem());

    return ResponseEntity.status(BAD_REQUEST).body(problem);
  }
}
