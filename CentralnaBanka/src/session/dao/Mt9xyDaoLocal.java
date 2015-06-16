package session.dao;

import java.util.List;

import entity.Mt9xy;

public interface Mt9xyDaoLocal extends GenericDaoLocal<Mt9xy, Integer> {

	public List<Mt9xy> findAllMT900();

	public List<Mt9xy> findAllMT910();

}
