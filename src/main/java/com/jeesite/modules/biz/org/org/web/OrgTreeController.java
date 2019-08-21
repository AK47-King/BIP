/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.org.org.web;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.biz.org.org.entity.OrgTree;
import com.jeesite.modules.biz.org.org.service.OrgTreeService;

/**
 * 测试树表Controller
 * @author ThinkGem
 * @version 2019-08-21
 */
@Controller
@RequestMapping(value = "${adminPath}/org/testTree")
public class OrgTreeController extends BaseController {

	@Autowired
	private OrgTreeService testTreeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public OrgTree get(String treeCode, boolean isNewRecord) {
		return testTreeService.get(treeCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("org:testTree:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrgTree testTree, Model model) {
		model.addAttribute("testTree", testTree);
		return "org/org/testTreeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("org:testTree:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<OrgTree> listData(OrgTree testTree) {
		if (StringUtils.isBlank(testTree.getParentCode())) {
			testTree.setParentCode(OrgTree.ROOT_CODE);
		}
		if (StringUtils.isNotBlank(testTree.getTreeName())){
			testTree.setParentCode(null);
		}
		if (StringUtils.isNotBlank(testTree.getRemarks())){
			testTree.setParentCode(null);
		}
		List<OrgTree> list = testTreeService.findList(testTree);
		return list;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("org:testTree:view")
	@RequestMapping(value = "form")
	public String form(OrgTree testTree, Model model) {
		// 创建并初始化下一个节点信息
		testTree = createNextNode(testTree);
		model.addAttribute("testTree", testTree);
		return "org/org/testTreeForm";
	}
	
	/**
	 * 创建并初始化下一个节点信息，如：排序号、默认值
	 */
	@RequiresPermissions("org:testTree:edit")
	@RequestMapping(value = "createNextNode")
	@ResponseBody
	public OrgTree createNextNode(OrgTree testTree) {
		if (StringUtils.isNotBlank(testTree.getParentCode())){
			testTree.setParent(testTreeService.get(testTree.getParentCode()));
		}
		if (testTree.getIsNewRecord()) {
			OrgTree where = new OrgTree();
			where.setParentCode(testTree.getParentCode());
			OrgTree last = testTreeService.getLastByParentCode(where);
			// 获取到下级最后一个节点
			if (last != null){
				testTree.setTreeSort(last.getTreeSort() + 30);
				testTree.setTreeCode(IdGen.nextCode(last.getTreeCode()));
			}else if (testTree.getParent() != null){
				testTree.setTreeCode(testTree.getParent().getTreeCode() + "001");
			}
		}
		// 以下设置表单默认数据
		if (testTree.getTreeSort() == null){
			testTree.setTreeSort(OrgTree.DEFAULT_TREE_SORT);
		}
		return testTree;
	}

	/**
	 * 保存组织机构
	 */
	@RequiresPermissions("org:testTree:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated OrgTree testTree) {
		testTreeService.save(testTree);
		return renderResult(Global.TRUE, text("保存组织机构成功！"));
	}
	
	/**
	 * 停用组织机构
	 */
	@RequiresPermissions("org:testTree:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(OrgTree testTree) {
		OrgTree where = new OrgTree();
		where.setStatus(OrgTree.STATUS_NORMAL);
		where.setParentCodes("," + testTree.getId() + ",");
		long count = testTreeService.findCount(where);
		if (count > 0) {
			return renderResult(Global.FALSE, text("该组织机构包含未停用的子组织机构！"));
		}
		testTree.setStatus(OrgTree.STATUS_DISABLE);
		testTreeService.updateStatus(testTree);
		return renderResult(Global.TRUE, text("停用组织机构成功"));
	}
	
	/**
	 * 启用组织机构
	 */
	@RequiresPermissions("org:testTree:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(OrgTree testTree) {
		testTree.setStatus(OrgTree.STATUS_NORMAL);
		testTreeService.updateStatus(testTree);
		return renderResult(Global.TRUE, text("启用组织机构成功"));
	}
	
	/**
	 * 删除组织机构
	 */
	@RequiresPermissions("org:testTree:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(OrgTree testTree) {
		testTreeService.delete(testTree);
		return renderResult(Global.TRUE, text("删除组织机构成功！"));
	}
	
	/**
	 * 获取树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequiresPermissions("org:testTree:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, String isShowCode) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<OrgTree> list = testTreeService.findList(new OrgTree());
		for (int i=0; i<list.size(); i++){
			OrgTree e = list.get(i);
			// 过滤非正常的数据
			if (!OrgTree.STATUS_NORMAL.equals(e.getStatus())){
				continue;
			}
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotBlank(excludeCode)){
				if (e.getId().equals(excludeCode)){
					continue;
				}
				if (e.getParentCodes().contains("," + excludeCode + ",")){
					continue;
				}
			}
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentCode());
			map.put("name", StringUtils.getTreeNodeName(isShowCode, e.getTreeCode(), e.getTreeName()));
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 修复表结构相关数据
	 */
	@RequiresPermissions("org:testTree:edit")
	@RequestMapping(value = "fixTreeData")
	@ResponseBody
	public String fixTreeData(OrgTree testTree){
		if (!UserUtils.getUser().isAdmin()){
			return renderResult(Global.FALSE, "操作失败，只有管理员才能进行修复！");
		}
		testTreeService.fixTreeData();
		return renderResult(Global.TRUE, "数据修复成功");
	}
	
}