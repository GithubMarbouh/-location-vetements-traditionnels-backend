package com.marbouh.locationdevetementstraditionnels.handlers;

import com.marbouh.locationdevetementstraditionnels.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

  private Integer httpCode;

  private ErrorCodes code;

  private String message;

  private List<String> errors = new ArrayList<>();

}
