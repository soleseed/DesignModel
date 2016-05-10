package com.cn.composite.v1;

import java.util.ArrayList;
import java.util.Collection;

public class Composite extends Component {

	private Collection<Component> ccs = new ArrayList<Component>();

	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Component c) {
		// TODO Auto-generated method stub
		ccs.add(c);
	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub
		ccs.remove(c);
	}

	@Override
	public void display(int depth) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			sb.append("-");
		}
		sb.append(this.name);
		System.out.println(sb.toString());

		for (Component c : ccs) {
			c.display(depth + 2);
		}
	}

	public static void main(String[] args) {
		Composite root = new Composite("root");
		root.add(new Leaf("LeafA"));
		root.add(new Leaf("LeafB"));

		Composite comp1 = new Composite("comp1");
		comp1.add(new Leaf("LeafAX"));
		comp1.add(new Leaf("LeafBX"));
		root.add(comp1);

		Composite comp2 = new Composite("comp2");
		comp2.add(new Leaf("LeafAY"));
		comp2.add(new Leaf("LeafBY"));
		comp1.add(comp2);

		root.add(new Leaf("LeafC"));
		Leaf leaf = new Leaf("LeafD");
		root.add(leaf);
		root.remove(leaf);

		root.display(1);
	}
}
