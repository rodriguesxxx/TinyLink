package br.com.tinylink.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.tinylink.api.utils.ShortenerUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShortenerUrlTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ShortenerUtil shortenerUtil;

    @Test
    public void isAliveApi() throws Exception {
        mockMvc.perform(get("/tinylink"))
                .andExpect(status().isAccepted());
    }

    @Test
    public void isShortenerUrl() throws Exception{
        String url = "https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.10.0";
        boolean isShortened = shortenerUtil.shortener(url) != null;
        Assertions.assertTrue(isShortened);
    }

	@Test
	public void wasRedirected() throws Exception{

        String url = "https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.10.0";
		String shortenedUrl = shortenerUtil.shortener(url);
        String[] splitUrl = shortenedUrl.split("/");
        String code = splitUrl[ splitUrl.length - 1 ];

        mockMvc.perform(MockMvcRequestBuilders.get("/tinylink/"+code))
		    .andExpect(MockMvcResultMatchers.redirectedUrl(url));
	}


}
