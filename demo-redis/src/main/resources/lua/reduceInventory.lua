local key = KEYS[1] -- 商品的键名
local amount = tonumber(ARGV[1]) -- 扣减的数量

-- 获取商品当前的库存量
local stock = tonumber(redis.call('get', key))

-- 如果库存足够，则减少库存并返回新的库存量
if stock >= amount then
    redis.call('decrby', key, amount)
    return redis.call('get', key)
else
    return "INSUFFICIENT STOCK"
end