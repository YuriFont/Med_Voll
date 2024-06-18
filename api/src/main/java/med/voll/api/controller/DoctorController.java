package med.voll.api.controller;

import med.voll.api.models.MedicalRegistrationData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void register(@RequestBody MedicalRegistrationData json) {
        System.out.println(json);
    }

}
