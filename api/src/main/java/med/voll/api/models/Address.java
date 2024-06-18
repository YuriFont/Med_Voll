package med.voll.api.models;

public record Address(String logradouro,
                      String bairro,
                      String cep,
                      String cidade,
                      String uf,
                      String numero,
                      String complemento) {
}
