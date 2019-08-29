package com.studerw.tda.model.trade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.apache.commons.lang3.StringUtils;

/**
 * Request class used to send an equity order {@link com.studerw.tda.client.TdaClient#tradeEquity(EquityOrder)}.
 * Use the {@link EquityOrderBldr} instead of constructor.
 * There are no public setters as this class is intended to be immutable to users.
 *
 */
public class EquityOrder {
  private String clientOrderId;
  @NotBlank(message="The account id cannot be empty. To use the default use 'client.getCurrentLogin().getXmlLogIn().getAssociatedAccountId()'")
  private String accountId;
  @NotNull(message = "Action cannot be empty - must be either 'sell', 'buy', 'sellshort' or 'buytocover'")
  private EquityAction action;
  private BigDecimal actPrice;
  @Min(value = 100,  message="display size needs to be integer value 100 or higher, in increments of 100")
  private Integer displaySize;
  @NotNull(message="expire type is required, one of [day, moc, day_ext, gtc, gtc_ext, am, pm]")
  private Expire expire;
  @Pattern(message="The expiration day must be a two digit day (e.g. 08 or 15)", regexp="\\d{2}|null")
  private String expireDay;
  @Pattern(message="The expiration month must be a two digit month (e.g. 08 or 11)", regexp="\\d{2}|null")
  private String expireMonth;
  @Pattern(message="The expiration year must be a two digit year (e.g. 20 for 2020)", regexp="\\d{2}|null")
  private String expireYear;
  @NotNull(message = "orderType required - must be one of [market, limit, stop_market, stop_limit, tstoppercent, tstopdollar]")
  private OrderType orderType;
  private BigDecimal price;
  @NotNull(message="the quantity must be set to 1 or more")
  @Positive(message="Must have 1 or more for quantity")
  private Integer quantity;
  private Routing routing;
  private SpecialInstruction specialInstruction;
  @NotEmpty(message = "the equity symbol in uppercase (e.g. MSFT) is missing.")
  private String symbol;
  private String tsParam;


  private EquityOrder(){}

  /**
   * Generated by the client software. It gets returned in the response for order matching.
   * It is optional, but a handy way to keep track of orders internally.
   * @return id set by the client
   */
  public String getClientOrderId() {
    return clientOrderId;
  }

  /**
   * The Account ID of the account in which the trade is being made. If this is not set initially,
   * the default account id of the account will be used.
   * @return account id used for the order
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Order action.
   * It is required and there is no default.
   * @return One of [sell, buy, sellshort, buytocover]
   */
  public EquityAction getAction() {
    return action;
  }

  /**
   * @return The stop price for stop market or stop limit orders.
   */
  public BigDecimal getActPrice() {
    return actPrice;
  }

  /**
   * Must be of type integer value 100 or higher, in increments of 100.
   * @return Level II display size if routing is INET, otherwise null.
   */
  public Integer getDisplaySize() {
    return displaySize;
  }

  /**
   *
   * @return One of [day, moc, day_ext, gtc, gtc_ext, am, pm]
   */
  public Expire getExpire() {
    return expire;
  }

  /**
   *
   * @return Two digit expiration day, only specified if expire is set to gtc otherwise null
   */
  public String getExpireDay() {
    return expireDay;
  }

  /**
   *
   * @return Two digit expiration month, only specified if expire is set to gtc otherwise null.
   */
  public String getExpireMonth() {
    return expireMonth;
  }

  /**
   *
   * @return Two digit expiration year, only specified if expire is set to gtc otherwise null.
   */
  public String getExpireYear() {
    return expireYear;
  }

  /**
   * Case sensitive value for order type. It is required.
   * @return one of [market, limit, stop_market, stop_limit, tstoppercent, tstopdollar]
   */
  public OrderType getOrderType() {
    return orderType;
  }

  /**
   * @return Limit price for limit or stop limit orders otherwise null
   */
  public BigDecimal getPrice() {
    return price;
  }

  /**
   * @return The number of shares being bought or sold in the transaction
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * User specified order routing destination. Default is auto
   * @return one of [auto, inet, ecn_arca]
   */
  public Routing getRouting() {
    return routing;
  }

  /**
   * Special Instructions for the order execution. Set to none if not specified
   * @return one of [none, fok, aon, dnr, aon_dnr]
   */
  public SpecialInstruction getSpecialInstruction() {
    return specialInstruction;
  }

  /**
   * @return Equity symbol, should be uppercase, e.g. MSFT or VTSAX
   */
  public String getSymbol() {
    return StringUtils.upperCase(symbol);
  }

  /**
   * Trailing Stop parameter in dollars or percent depending on order type otherwise null.
   * @return trailing stop. In case of percent, 5 means 5 percent
   */
  public String getTsParam() {
    return tsParam;
  }

  void setClientOrderId(String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  void setAction(EquityAction action) {
    this.action = action;
  }

  void setActPrice(BigDecimal actPrice) {
    this.actPrice = actPrice;
  }

  void setDisplaySize(Integer displaySize) {
    this.displaySize = displaySize;
  }

  void setExpire(Expire expire) {
    this.expire = expire;
  }

  void setExpireDay(String expireDay) {
    this.expireDay = expireDay;
  }

  void setExpireMonth(String expireMonth) {
    this.expireMonth = expireMonth;
  }

  void setExpireYear(String expireYear) {
    this.expireYear = expireYear;
  }

  void setOrderType(OrderType orderType) {
    this.orderType = orderType;
  }

  void setPrice(BigDecimal price) {
    this.price = price;
  }

  void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  void setRouting(Routing routing) {
    this.routing = routing;
  }

  void setSpecialInstruction(SpecialInstruction specialInstruction) {
    this.specialInstruction = specialInstruction;
  }

  void setSymbol(String symbol) {
    this.symbol = StringUtils.upperCase(symbol);
  }

  void setTsParam(String tsParam) {
    this.tsParam = tsParam;
  }

  /**
   *LOGGER.debug("Using orderString: {}", orderString);
   * @return list of map of query params that aren't empty or null
   */
  public Map<String, String> toQueryStringMap(){
    Map<String, String> params = new HashMap<>();

    if (StringUtils.isNotBlank(this.clientOrderId)) {
      params.put("clientorderid", this.clientOrderId);
    }
    if (StringUtils.isNotBlank(this.accountId)) {
      params.put("accountid", this.accountId);
    }
    if (this.action != null) {
      params.put("action", this.action.toString());
    }
    if (this.actPrice != null) {
      params.put("actprice", this.actPrice.toString());
    }
    if (this.displaySize != null) {
      params.put("displaysize", this.displaySize.toString());
    }
    if (this.expire != null){
      params.put("expire", this.expire.toString());
    }
    if (StringUtils.isNotBlank(this.expireDay)){
      params.put("exday", this.expireDay.toString());
    }
    if (StringUtils.isNotBlank(this.expireMonth)){
      params.put("exmonth", this.expireMonth.toString());
    }
    if (StringUtils.isNotBlank(this.expireYear)){
      params.put("exyear", this.expireYear.toString());
    }
    if (this.orderType != null) {
      params.put("ordtype", this.orderType.toString());
    }
    if (this.price != null) {
      params.put("price", this.price.toString());
    }
    if (this.quantity != null) {
      params.put("quantity", this.quantity.toString());
    }
    if (this.routing != null) {
      params.put("routing", this.routing.toString());
    }
    if (this.specialInstruction != null) {
      params.put("spinstructions", this.specialInstruction.toString());
    }
    if (StringUtils.isNotBlank(this.symbol)) {
      params.put("symbol", this.symbol.toUpperCase());
    }
    if (StringUtils.isNotBlank(this.tsParam)) {
      params.put("tsparam", this.tsParam);
    }

    return params;
  }

  /**
   *
   * @param key query key (e.g. orderstring)
   * @return query string of parameters separated by '~' as per TDA API requirements
   */
  public String toQueryString(String key) {
    Map<String, String> equityOrderParams = this.toQueryStringMap();
    String orderString = equityOrderParams.keySet().stream()
        .map(k -> k + "=" + equityOrderParams.get(k)).collect(Collectors.joining("~"));
    return orderString;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", EquityOrder.class.getSimpleName() + "[", "]")
        .add("clientOrderId='" + clientOrderId + "'")
        .add("accountId='" + accountId + "'")
        .add("action=" + action)
        .add("actPrice=" + actPrice)
        .add("displaySize=" + displaySize)
        .add("expire=" + expire)
        .add("expireDay=" + expireDay)
        .add("expireMonth=" + expireMonth)
        .add("expireYear=" + expireYear)
        .add("orderType=" + orderType)
        .add("price=" + price)
        .add("quantity=" + quantity)
        .add("routing=" + routing)
        .add("specialInstruction=" + specialInstruction)
        .add("symbol='" + symbol + "'")
        .add("tsParam='" + tsParam + "'")
        .toString();
  }

  public static final class EquityOrderBldr {

    private String clientOrderId;
    private String accountId;
    private EquityAction action;
    private BigDecimal actPrice;
    private Integer displaySize;
    private Expire expire;
    private String expireDay;
    private String expireMonth;
    private String expireYear;
    private OrderType orderType;
    private BigDecimal price;
    private Integer quantity;
    private Routing routing = Routing.auto;
    private SpecialInstruction specialInstruction = SpecialInstruction.none;
    private String symbol;
    private String tsParam;

    private EquityOrderBldr() {
    }

    public static EquityOrderBldr anEquityOrder() {
      return new EquityOrderBldr();
    }

    public EquityOrderBldr withClientOrderId(String clientOrderId) {
      this.clientOrderId = clientOrderId;
      return this;
    }

    public EquityOrderBldr withAccountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    public EquityOrderBldr withAction(EquityAction action) {
      this.action = action;
      return this;
    }

    public EquityOrderBldr withActPrice(BigDecimal actPrice) {
      this.actPrice = actPrice;
      return this;
    }

    public EquityOrderBldr withDisplaySize(Integer displaySize) {
      this.displaySize = displaySize;
      return this;
    }

    public EquityOrderBldr withExpire(Expire expire) {
      this.expire = expire;
      return this;
    }

    public EquityOrderBldr withExpireDay(String expireDay) {
      this.expireDay = expireDay;
      return this;
    }

    public EquityOrderBldr withExpireMonth(String expireMonth) {
      this.expireMonth = expireMonth;
      return this;
    }

    public EquityOrderBldr withExpireYear(String expireYear) {
      this.expireYear = expireYear;
      return this;
    }

    public EquityOrderBldr withOrderType(OrderType orderType) {
      this.orderType = orderType;
      return this;
    }

    public EquityOrderBldr withPrice(BigDecimal price) {
      this.price = price;
      return this;
    }

    public EquityOrderBldr withQuantity(Integer quantity) {
      this.quantity = quantity;
      return this;
    }

    public EquityOrderBldr withRouting(Routing routing) {
      this.routing = routing;
      return this;
    }

    public EquityOrderBldr withSpecialInstruction(SpecialInstruction specialInstruction) {
      this.specialInstruction = specialInstruction;
      return this;
    }

    public EquityOrderBldr withSymbol(String symbol) {
      this.symbol = StringUtils.upperCase(symbol);
      return this;
    }

    public EquityOrderBldr withTsParam(String tsParam) {
      this.tsParam = tsParam;
      return this;
    }

    public EquityOrder build() {
      EquityOrder equityOrder = new EquityOrder();
      equityOrder.actPrice = this.actPrice;
      equityOrder.specialInstruction = this.specialInstruction;
      equityOrder.price = this.price;
      equityOrder.clientOrderId = this.clientOrderId;
      equityOrder.symbol = this.symbol;
      equityOrder.expireDay = this.expireDay;
      equityOrder.orderType = this.orderType;
      equityOrder.displaySize = this.displaySize;
      equityOrder.routing = this.routing;
      equityOrder.accountId = this.accountId;
      equityOrder.action = this.action;
      equityOrder.quantity = this.quantity;
      equityOrder.expireYear = this.expireYear;
      equityOrder.expire = this.expire;
      equityOrder.expireMonth = this.expireMonth;
      equityOrder.tsParam = this.tsParam;
      return equityOrder;
    }
  }
}

