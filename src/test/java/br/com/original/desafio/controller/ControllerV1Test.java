package br.com.original.desafio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApp() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/test");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void whenSaveProcesso_thenCorrect() throws Exception {

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("http://localhost:8080/api/v1/processos");
        post.contentType(MediaType.APPLICATION_JSON);
        post.content("{\"cnj\": \"0000000-00.2020.8.26.0000\", \"autor\": \"Fulano de Tal\", \"reu\": \"Empresa da Silva\"}");
        post.accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cnj").value("0000000-00.2020.8.26.0000"));
    }

    @Test
    public void whenSaveProcesso_thenFail() throws Exception {

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("http://localhost:8080/api/v1/processos");
        post.contentType(MediaType.APPLICATION_JSON);
        post.content("{\"cnj\": \"\", \"autor\": \"Autor da Silva\", \"reu\": \"Reu dos Santos\"}");
        post.accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isAccepted());
    }

}