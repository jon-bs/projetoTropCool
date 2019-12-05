package com.tropcool.model.entity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Post extends AbstractEntity implements Serializable{
	
	@JsonIgnoreProperties({"configuracaoAgenda","posts","endereco"})
	@NotNull
	@ManyToOne(
			    targetEntity = Tatuador.class, 
			    fetch = FetchType.LAZY, 
			    optional = false
			)
    private Tatuador tatuador;
	
	@NotNull
    private Boolean bloqueado;
	
	@Column(name = "image", nullable = true)
	private byte[] image;
	 
	public byte[] openImg(String path) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		return bytes;
	}
	
	public Image writeImg(byte[] imagem) {
		Image img = new ImageIcon(imagem).getImage();
		//ByteImg byteI = new ByteImg(); byteI.byteImg(byte[])
		return img;
	}
	
}
