package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.entity.Group;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupDao extends AbstractDao<Integer, Group> {

	private final static String SQL_CREATE = "INSERT INTO groups (id,name) VALUES (DEFAULT,?);";
	private final static String SQL_DELETE = "DELETE FROM groups WHERE id=?;";
	private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE groups SET name =? WHERE id =?;";
	private final static String SQL_GET_BY_ID = "SELECT * FROM groups WHERE id=?;";
	private final static String SQL_GET_ALL = "SELECT * FROM groups;";
	private Executor executor;

	public GroupDao() {
		this.executor = new Executor();
	}

	@Override
	public Group getById(Integer id) throws SQLException {
		return executor.execQuery(SQL_GET_BY_ID, result -> {
			result.next();
			return new Group(result.getInt("id"), result.getString("name"));
		}, id);
	}

	@Override
	public void create(Group group) throws SQLException {
		executor.execUpdate(SQL_CREATE, group.getName());

	}

	@Override
	public List<Group> getAll() throws SQLException {
		return executor.execQuery(SQL_GET_ALL, result -> {
			List<Group> all = new ArrayList<>();
			while (result.next()) {
				all.add(new Group(result.getInt("id"), result.getString("name")));
			}
			return all;
		});
	}

	@Override
	public void delete(Group entity) throws SQLException {
		executor.execUpdate(SQL_DELETE, entity.getId());

	}

	@Override
	public void update(Group entity, Integer id) throws SQLException {
		log.info("start groupdao Update name by ID");
		executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getName(), id);

	}

}
