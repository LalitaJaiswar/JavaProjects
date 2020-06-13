import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVideo {

	@Test
	void testGetName() {
		Video v=new Video("Music1");
		assertEquals("Music1",v.getName());
	}

}
