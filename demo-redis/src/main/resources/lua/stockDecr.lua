local function deductStock(stockField, deductAmount)
    local currentStock = tonumber(redis.call('hget', KEYS[1], stockField))

    if not currentStock or (currentStock < deductAmount) then
        return -1 -- 库存不足
    end

    redis.call('hincrby', KEYS[1], stockField, -deductAmount)
    return currentStock - deductAmount -- 返回剩余库存量
end

return deductStock(KEYS[2], tonumber(ARGV[1]))
