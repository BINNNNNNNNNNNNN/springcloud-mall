package com.mall.item.api;

import com.mall.common.pojo.PageResult;
import com.mall.item.bo.SpuBo;
import com.mall.item.pojo.Sku;
import com.mall.item.pojo.SpuDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/24 9:06
 * @ Description：商品服务接口
 * @ Modified By：
 */
@RequestMapping("goods")
public interface GoodsApi {
    /**
     * 分页查询
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @param saleable
     * @return
     */
    @GetMapping("/spu/page")
    PageResult<SpuBo> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable",defaultValue = "true") Boolean saleable);

    /**
     * 根据spu商品id查询详情
     * @param id
     * @return
     */
    @GetMapping("/spu/detail/{id}")
    SpuDetail querySpuDetailBySpuId(@PathVariable("id") Long id);

    /**
     * 根据Spu的id查询其下所有的sku
     * @param id
     * @return
     */
    @GetMapping("sku/list")
    List<Sku> querySkuBySpuId(Long id);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @GetMapping("/spu/{id}")
    SpuBo queryGoodsById(@PathVariable("id") Long id);
}
