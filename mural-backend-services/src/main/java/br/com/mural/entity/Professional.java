package br.com.mural.entity;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel( value = "Professional", description = "This is a representation of a Professional" )
public class Professional {

	@ObjectId @Id 
	private String id;
	private String name;
	private List<Address> addresses;
	private String cpf;
	private String birthDate;
	private List<String> keywords;
	private String serviceSummary;
	private String site;
	private String portfolio;
	
	
	public Professional() {
		super();
	}

	public Professional(String name, List<Address> addresses, String cpf,
			String birthDate, List<String> keywords, String serviceSummary,
			String site, String portfolio) {
		super();
		this.name = name;
		this.addresses = addresses;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.keywords = keywords;
		this.serviceSummary = serviceSummary;
		this.site = site;
		this.portfolio = portfolio;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public String getServiceSummary() {
		return serviceSummary;
	}
	public void setServiceSummary(String serviceSummary) {
		this.serviceSummary = serviceSummary;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result
				+ ((serviceSummary == null) ? 0 : serviceSummary.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professional other = (Professional) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portfolio == null) {
			if (other.portfolio != null)
				return false;
		} else if (!portfolio.equals(other.portfolio))
			return false;
		if (serviceSummary == null) {
			if (other.serviceSummary != null)
				return false;
		} else if (!serviceSummary.equals(other.serviceSummary))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Professional [id=" + id + ", name=" + name + ", addresses="
				+ addresses + ", cpf=" + cpf + ", birthDate=" + birthDate
				+ ", keywords=" + keywords + ", serviceSummary="
				+ serviceSummary + ", site=" + site + ", portfolio="
				+ portfolio + "]";
	}
	
	
	
	
}
