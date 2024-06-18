package med.voll.api.models;

public record MedicalRegistrationData(String nome,
                                      String email,
                                      String crm,
                                      Specialty especialidade,
                                      Address endereco) {
}
