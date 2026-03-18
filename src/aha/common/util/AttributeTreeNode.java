package aha.common.util;

import static java.util.Objects.requireNonNull;
import static aha.common.guard.LogicGuards.throwIf;
import static aha.common.guard.CollectionGuards.requireNoDuplicate;

import java.util.List;

public final class AttributeTreeNode extends AttributeBase<AttributeTreeNode> {
	private final AttributeTreeNode parent;
	private List<AttributeTreeNode> children = null;
	
	public AttributeTreeNode() { this.parent = null; }
	
	public AttributeTreeNode(AttributeTreeNode parent) {
		this.parent = requireNonNull(parent, "parent"); }
	
	public AttributeTreeNode parent() { return this.parent; }
	
	public final boolean isRoot() { return this.parent == null; }
	
	public final boolean isLeaf() {
		return this.children == null || this.children.isEmpty(); }
	
	public final int childCount() {
		return this.children == null ? 0 : this.children.size(); }
	
	public final AttributeTreeNode getChild(int idx) {
		if (idx < 0 || this.isLeaf()) throw new IndexOutOfBoundsException(idx);
		return this.children.get(idx);
	}
	
	public final int indexOf(AttributeTreeNode node) {
		requireNonNull(node, "node");
		return this.isLeaf() ? -1 : this.indexOf(node);
	}
	
	public final AttributeTreeNode addChild(AttributeTreeNode node) {
		requireNonNull(node, "none");
		throwIf(node == this, "can not have self as child");
		requireNoDuplicate(node, this.children, "already a child");
		this.children.add(node);
		return this;
	}
	
}
