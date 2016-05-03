module Inventoryable
end

class Shirt
  attr_accessor :attributes

  def initialize(attributes)
    @attributes = attributes
  end
end

class Pant
  attr_accessor :attributes

  def initialize(attributes)
    @attributes = attributes
  end
end

class Accessory
  attr_accessor :attributes

  def initialize(attributes)
    @attributes = attributes
  end
end

shirt1 = Shirt.new(name: "MTF", size: "L")
shirt2 = Shirt.new(name: "MTF", size: "M")
