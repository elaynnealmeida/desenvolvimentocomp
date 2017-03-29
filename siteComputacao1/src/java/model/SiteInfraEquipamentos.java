/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_infra_equipamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteInfraEquipamentos.findAll", query = "SELECT s FROM SiteInfraEquipamentos s"),
    @NamedQuery(name = "SiteInfraEquipamentos.findById", query = "SELECT s FROM SiteInfraEquipamentos s WHERE s.id = :id")})
public class SiteInfraEquipamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "equipamento_id", referencedColumnName = "id")
    @ManyToOne
    private SiteEquipamento equipamentoId;
    @JoinColumn(name = "infraestrutura_id", referencedColumnName = "id")
    @ManyToOne
    private SiteInfraestrutura infraestruturaId;

    public SiteInfraEquipamentos() {
    }

    public SiteInfraEquipamentos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SiteEquipamento getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(SiteEquipamento equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public SiteInfraestrutura getInfraestruturaId() {
        return infraestruturaId;
    }

    public void setInfraestruturaId(SiteInfraestrutura infraestruturaId) {
        this.infraestruturaId = infraestruturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteInfraEquipamentos)) {
            return false;
        }
        SiteInfraEquipamentos other = (SiteInfraEquipamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteInfraEquipamentos[ id=" + id + " ]";
    }
    
}
