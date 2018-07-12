import com.sxsqli.domain.NoteFile;
import com.sxsqli.mapper.NoteFileMapper;
import com.sxsqli.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NoteTest {
    private SqlSession sqlSession;
    private NoteFileMapper noteFileMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        noteFileMapper = sqlSession.getMapper(NoteFileMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void ins() {
        NoteFile noteFile = new NoteFile();
        noteFile.setFilename("fdsagdf");
        noteFile.setPath("ewqeq");
        noteFile.setUserid(5);
        noteFileMapper.insert(noteFile);
    }

    @Test
    public void del() {
        NoteFile noteFile = new NoteFile();
        noteFile.setFilename("das");
        noteFile.setPath("ewqeq");
        noteFile.setUserid(1);
        noteFile.setNid(2);
        noteFileMapper.delete(noteFile);
    }

    @Test
    public void fin() {
        List<NoteFile> noteFiles = noteFileMapper.findAll();
        for (NoteFile noteFile : noteFiles) {
            System.out.println(noteFile.getFilename());
            System.out.println(noteFile.getUser().getUsername());
        }
    }

    @Test
    public void finB() {
        NoteFile noteFile = new NoteFile();
        noteFile.setUserid(1);
        noteFile.setNid(6);
        List<NoteFile> noteFiles = noteFileMapper.findByNoteFile(noteFile);
        for (NoteFile nf : noteFiles) {
            System.out.println(nf.getFilename());
        }
    }
    @Test
    public void finL() {
        List<NoteFile> noteFiles = noteFileMapper.findLike("%a%");
        for (NoteFile nf : noteFiles) {
            System.out.println(nf.getFilename());
        }
    }
}
