package com.disney.explore.domain.request;

import com.disney.explore.common.validation.ValidationMessages;
import com.disney.explore.domain.entity.Character;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

  private String image;
  private String titulo;
  private String fechaCreacion;
  @Min(value = 1, message = ValidationMessages.REQUEST_PARAM_RANGE_ERROR_MESSAGE)
  @Max(value = 5, message = ValidationMessages.REQUEST_PARAM_RANGE_ERROR_MESSAGE)
  private Integer calificacion;
  private List<Character> personajes;

}
