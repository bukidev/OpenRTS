/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package model.builders.entity.definitions;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

/**
 * @author Benoît
 */
public class Definition {
	private String id;
	private String type;

	// private boolean upToDate = true;

	private List<DefElement> elements = new ArrayList<>();

	@Inject
	public Definition(String type, String id) {
		this.type = type;
		this.id = id;
	}

	
//	public Definition(Definition other) {
//		this.id = other.getId();
//		type = other.getType();
//		elements = new ArrayList<>(other.elements);
//	}

	public boolean equals(Definition other) {
		if (!getId().equals(other.getId())) {
			return false;
		}
		if (!getType().equals(other.getType())) {
			return false;
		}

		for (int i = 0; i < elements.size(); i++) {
			if (!elements.get(i).equals(other.elements.get(i))) {
				return false;
			}
		}

		return true;
	}

	public void updateElements(ArrayList<DefElement> elements) {
		this.elements.clear();
		this.elements.addAll(elements);
	}

	public DefElement getElement(String name) {
		for (DefElement element : elements) {
			if (element.name.equals(name)) {
				return element;
			}
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public List<DefElement> getElements() {
		return elements;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setType(String type) {
		this.type = type;
	}

}
