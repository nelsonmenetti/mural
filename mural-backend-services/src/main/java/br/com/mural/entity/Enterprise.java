package br.com.mural.entity;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel( value = "Enterprise", description = "This is a representation of a Enterprise" )
public class Enterprise {
	
	@ObjectId @Id 
	private String id;
	private String name;
	private List<Address> addresses;
	private String cnpj;
	private String startingDate;
	private List<String> keywords;
	private String serviceSummary;
	private String site;
	private String portfolio;
	
	public Enterprise() {
		super();
	}
	public Enterprise(String name, List<Address> addresses, String cnpj,
			String startingDate, List<String> keywords, String serviceSummary,
			String site, String portfolio) {
		super();
		this.name = name;
		this.addresses = addresses;
		this.cnpj = cnpj;
		this.startingDate = startingDate;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
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
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result
				+ ((serviceSummary == null) ? 0 : serviceSummary.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result
				+ ((startingDate == null) ? 0 : startingDate.hashCode());
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
		Enterprise other = (Enterprise) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
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
		if (startingDate == null) {
			if (other.startingDate != null)
				return false;
		} else if (!startingDate.equals(other.startingDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", name=" + name + ", addresses="
				+ addresses + ", cnpj=" + cnpj + ", startingDate="
				+ startingDate + ", keywords=" + keywords + ", serviceSummary="
				+ serviceSummary + ", site=" + site + ", portfolio="
				+ portfolio + "]";
	}
	 
}
