package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnderecoTest {

    @Test
    public void testaBuilder() {
        Endereco e = Endereco.builder().rua("Rua T-48").cep("74210190").cidade("Goiânia").numero(1076).build();

        assertEquals(e.getRua(), "Rua T-48");
        assertEquals(e.getCidade(),"Goiânia");
        assertEquals(e.getCep(),"74210190");
        assertEquals(e.getCep(),"74210190");
        assertEquals(e.getNumero(), 1076);
    }

    @Test
    public void testaBuilderEqualsConstructorObject(){
        Endereco end1 = new Endereco("Rua Cel. Ricardo Paranhos", "Campinas", "74000000", 123, "Goiânia","Goiás","1","7");
        Endereco end2 = Endereco.builder().rua("Rua Cel. Ricardo Paranhos").setor("Campinas").cep("74000000").numero(123).cidade("Goiânia").estado("Goiás").bloco("1").quadra("7").build();
        assertEquals(end1, end2);
    }
}