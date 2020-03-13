package com.suixin.jdbc;

import com.suixin.jdbc.util.MysqlUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class MysqlApi extends JavaPlugin {
	@Override
	public void onEnable() {
//		new MysqlUtil()
		getLogger().info("==================[Tavern]==================");
		try {
			new MysqlUtil().LoadDbData(this);//加载数据库驱动
			new MysqlUtil().LoadDbData(this);//加载数据库驱动
//			if (connection) {
//				getLogger().info("Mysql连接成功");
//			}
		}catch (Exception e){
			getLogger().info("Mysql连接失败:"+e.getMessage());
			getLogger().info("如有疑问，请联系开发人员解决：QQ:2469012478");
		}
		getLogger().info("==================[Tavern]==================");
	}
}
