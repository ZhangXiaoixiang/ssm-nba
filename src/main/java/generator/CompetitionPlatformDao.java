package generator;

import com.example.nba.model.CompetitionPlatform;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompetitionPlatformDao {
    long countByExample(CompetitionPlatformExample example);

    int deleteByExample(CompetitionPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionPlatform record);

    int insertSelective(CompetitionPlatform record);

    List<CompetitionPlatform> selectByExample(CompetitionPlatformExample example);

    CompetitionPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompetitionPlatform record, @Param("example") CompetitionPlatformExample example);

    int updateByExample(@Param("record") CompetitionPlatform record, @Param("example") CompetitionPlatformExample example);

    int updateByPrimaryKeySelective(CompetitionPlatform record);

    int updateByPrimaryKey(CompetitionPlatform record);
}