package xruisu.project.unitylink.unitylink_api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xruisu.project.unitylink.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class APITests {

	private static final Logger logger = LoggerFactory.getLogger(APITests.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void tests() {

	}
}