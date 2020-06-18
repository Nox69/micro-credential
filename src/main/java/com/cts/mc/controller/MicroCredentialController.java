package com.cts.mc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.model.MicroCredentialRequest;
import com.cts.mc.model.MicroCredentialResponse;
import com.cts.mc.service.MicroCredentialService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api("Micro-Credential Rest API")
@AllArgsConstructor
public class MicroCredentialController {

	private final MicroCredentialService service;

	@GetMapping(value = "/details/retrieve")
	private ResponseEntity<List<MicroCredentialResponse>> retrieveDetails() {
		return ResponseEntity.ok().body(service.retrieveDetails());
	}

	@PostMapping(value = "/details/save")
	private ResponseEntity<MicroCredentialResponse> saveDetails(
			@RequestBody MicroCredentialRequest microCredentialRequest) {
		if (microCredentialRequest.getApi().isEmpty())
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.ok().body(service.saveDetails(microCredentialRequest));
	}

	@DeleteMapping(value = "/details/delete/{deleteId}")
	private ResponseEntity<String> deleteDetails(@PathVariable String deleteId) {
		return ResponseEntity.ok().body("successful Deleted");
	}
}
