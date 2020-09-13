package projeto.SambaTech.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.SambaTech.dtos.MidiasDto;
import projeto.SambaTech.entities.Midias;
import projeto.SambaTech.response.Response;
import projeto.SambaTech.services.MidiasService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/midias")
@CrossOrigin(origins = "*")
public class MidiasController {


}
