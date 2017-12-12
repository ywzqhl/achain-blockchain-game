package com.achain.blockchain.game.service.impl;

import com.achain.blockchain.game.domain.entity.BlockchainDogOrder;
import com.achain.blockchain.game.domain.enums.OrderStatus;
import com.achain.blockchain.game.mapper.BlockchainDogOrderMapper;
import com.achain.blockchain.game.service.IBlockchainDogOrderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yujianjian
 * @since 2017-12-12 下午4:11
 */
@Service
public class BlockchainDogOrderServiceImpl extends ServiceImpl<BlockchainDogOrderMapper, BlockchainDogOrder>
    implements IBlockchainDogOrderService {

    @Override
    public List<BlockchainDogOrder> listByDogIdAndStatus(Integer dogId, OrderStatus orderStatus) {
        EntityWrapper<BlockchainDogOrder> wrapper = new EntityWrapper<>();
        wrapper.where("dog_id={0}",dogId).and("status={0}",orderStatus.getIntKey());
        return baseMapper.selectList(wrapper);
    }
}
