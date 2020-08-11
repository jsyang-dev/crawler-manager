package link.crawler.manager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class CrawlingExecution extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crawling_master_id")
    private CrawlingMaster crawlingMaster;

    @Column(nullable = false)
    private String siteUrl;

    @Column(nullable = false, columnDefinition = "text")
    private String executionCode;

    public void changeCrawlingMaster(CrawlingMaster crawlingMaster) {
        this.crawlingMaster = crawlingMaster;
        crawlingMaster.getCrawlingExecutionList().add(this);
    }
}
