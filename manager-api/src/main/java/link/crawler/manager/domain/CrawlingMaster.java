package link.crawler.manager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class CrawlingMaster extends BaseEntity {

    @Column(nullable = false)
    private String subject;

    @OneToMany(mappedBy = "crawlingMaster")
    private List<CrawlingExecution> crawlingExecutionList = new ArrayList<>();

    @OneToMany(mappedBy = "crawlingMaster")
    private List<CrawlingSchedule> crawlingScheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "crawlingMaster")
    private List<ResultMaster> resultMasterList = new ArrayList<>();
}
