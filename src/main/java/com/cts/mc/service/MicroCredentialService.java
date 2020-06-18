package com.cts.mc.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.cts.mc.model.MicroCredentialRequest;
import com.cts.mc.model.MicroCredentialResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MicroCredentialService {

	public MicroCredentialResponse saveDetails(MicroCredentialRequest microCredentialRequest) {
		return MicroCredentialResponse.builder().apiKey("1231asdasdas34gsfdssdq3gsg").website("https://rapidApi.com.")
				.build();
	}

	public List<MicroCredentialResponse> retrieveDetails() {
		return Stream.of(
				MicroCredentialResponse.builder().apiKey("1231a-sdasdas34gsf0-dssdq3gsg")
						.website("https://rapidApi.com.").build(),
				MicroCredentialResponse.builder().apiKey("fa23da-0asdasd1qfaa-asq6uc").website("https://google.com.")
						.build(),
				MicroCredentialResponse.builder().apiKey("1asf134as-123123ttasjfkftf-d563dgf")
						.website("https://facebook.com.").build())
				.collect(Collectors.toList());

	}

}
