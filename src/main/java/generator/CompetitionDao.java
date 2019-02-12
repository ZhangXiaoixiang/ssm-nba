package generator;

import com.example.nba.model.Competition;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompetitionDao {
    long countByExample(CompetitionExample example);

    int deleteByExample(CompetitionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Competition record);

    int insertSelective(Competition record);

    List<Competition> selectByExample(CompetitionExample example);

    Competition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByExample(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}