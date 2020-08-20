package link.crawler.manager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ResultMaster extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crawling_master_id")
    private CrawlingMaster crawlingMaster;

    @Column(nullable = false)
    private int resultCount;

    @Column(nullable = false)
    private boolean successYn;

    @Column(nullable = false)
    private boolean sendYn;

    @OneToMany(mappedBy = "resultMaster")
    private List<ResultDetail> resultDetailList = new ArrayList<>();

    public void changeCrawlingMaster(CrawlingMaster crawlingMaster) {
        this.crawlingMaster = crawlingMaster;
        crawlingMaster.getResultMasterList().add(this);
    }
}
