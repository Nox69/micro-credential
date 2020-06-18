package com.cts.mc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
public class MicroCredentialResponse {

	private String apiKey;
	private String website;

}
