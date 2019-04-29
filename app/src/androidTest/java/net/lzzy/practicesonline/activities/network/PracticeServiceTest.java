package net.lzzy.practicesonline.activities.network;

import net.lzzy.practicesonline.activities.models.Practice;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/4/22.
 * Description:
 */
public class PracticeServiceTest {

    @Test
    public void testGetPracticesFrcomServer() throws IOException {
        String actual =PracticeService.getPracticesFrcomServer();
        assertTrue(actual.contains("测试阶段的划分"));

    }

    @Test
    public void testGetPractices() throws IOException, IllegalAccessException, JSONException, InstantiationException {
         String json =PracticeService.getPracticesFrcomServer();
        List<Practice> practices =PracticeService.getPractices(json);
        assertEquals(5,practices.size());
        assertEquals(33,practices.get(0).getApiId());
        assertEquals("测试阶段划分",practices.get(0).getName());
        assertEquals(9,practices.get(0).getQuestionCount());
        assertTrue(practices.get(0).getOutlines().contains("单元测试"));
    }
}