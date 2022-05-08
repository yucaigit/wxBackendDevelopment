package generator.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName attribute
 */
@Data
public class Attribute implements Serializable {
    /**
     *
     */
    private Integer aId;

    /**
     *
     */
    private String aName;

    /**
     *
     */
    private String aGrade;

    /**
     *
     */
    private Integer aCount;

    /**
     *
     */
    private String aA;

    /**
     *
     */
    private String aB;

    /**
     *
     */
    private String aC;

    private static final long serialVersionUID = 1L;
}