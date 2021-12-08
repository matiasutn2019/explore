package com.disney.explore.domain.request;

import com.disney.explore.common.validation.ValidationMessages;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  private String image;
  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  private String titulo;
  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  private String fechaCreacion;
  @Min(value = 1, message = ValidationMessages.REQUEST_PARAM_RANGE_ERROR_MESSAGE)
  @Max(value = 5, message = ValidationMessages.REQUEST_PARAM_RANGE_ERROR_MESSAGE)
  private Integer calificacion;
  private List<Long> personajesId;

}
