package link.crawler.manager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class CrawlingSchedule extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crawling_master_id")
    private CrawlingMaster crawlingMaster;

    @Column(nullable = false)
    private String cronExpression;

    public void changeCrawlingMaster(CrawlingMaster crawlingMaster) {
        this.crawlingMaster = crawlingMaster;
        crawlingMaster.getCrawlingScheduleList().add(this);
    }
}
