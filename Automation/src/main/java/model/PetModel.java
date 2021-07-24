package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class PetModel{
	private List<String> photoUrls;
	private String name;
	private Integer id;
	private CategoryModel category;
	private List<TagsItemModel> tags;
	private String status;
}