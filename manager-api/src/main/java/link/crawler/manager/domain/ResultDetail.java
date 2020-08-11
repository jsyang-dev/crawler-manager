package link.crawler.manager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class ResultDetail extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_master_id")
    private ResultMaster resultMaster;

    @Column(nullable = false)
    private String siteUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private String link;

    public void changeResultMaster(ResultMaster resultMaster) {
        this.resultMaster = resultMaster;
        resultMaster.getResultDetailList().add(this);
    }
}
