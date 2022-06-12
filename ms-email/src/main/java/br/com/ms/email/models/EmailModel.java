package br.com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ms.email.enums.StatusEmail;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {

	private static final long serialVersionUID = 3830628415129720528L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID emailId;
	
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	private LocalDateTime sendDateEmail;
	
	@Enumerated(EnumType.STRING)
	private StatusEmail statusEmail;

}
