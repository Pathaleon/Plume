/**
 * This class is generated by jOOQ
 */
package com.skcraft.plume.common.sql.model.data.tables.records;


import com.skcraft.plume.common.sql.model.data.tables.UserGroup;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserGroupRecord extends UpdatableRecordImpl<UserGroupRecord> implements Record2<Integer, Integer> {

	private static final long serialVersionUID = -1544027615;

	/**
	 * Setter for <code>data.user_group.user_id</code>.
	 */
	public void setUserId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>data.user_group.user_id</code>.
	 */
	public Integer getUserId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>data.user_group.group_id</code>.
	 */
	public void setGroupId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>data.user_group.group_id</code>.
	 */
	public Integer getGroupId() {
		return (Integer) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record2<Integer, Integer> key() {
		return (Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return UserGroup.USER_GROUP.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return UserGroup.USER_GROUP.GROUP_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getGroupId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserGroupRecord value1(Integer value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserGroupRecord value2(Integer value) {
		setGroupId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserGroupRecord values(Integer value1, Integer value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserGroupRecord
	 */
	public UserGroupRecord() {
		super(UserGroup.USER_GROUP);
	}

	/**
	 * Create a detached, initialised UserGroupRecord
	 */
	public UserGroupRecord(Integer userId, Integer groupId) {
		super(UserGroup.USER_GROUP);

		setValue(0, userId);
		setValue(1, groupId);
	}
}