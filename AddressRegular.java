public class AddressRegular  {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String add="大村村村村里26鄰26號";
		 Optional<Function<String, Optional<String>>> contactAddr2ResolverOpt = Optional.ofNullable(add).filter(StringUtils::isNotBlank).flatMap(Test::handleAddressResolver);
		 String contAddrSection1 = contactAddr2ResolverOpt.flatMap(fun -> fun.apply("village")).map(str -> str.replaceAll("村$", StringUtils.EMPTY)).orElse(null);
	       
		 String contAddrSection2 = contactAddr2ResolverOpt.flatMap(fun -> fun.apply("vil")).map(str -> str.replaceAll("里$", StringUtils.EMPTY)).orElse(null);
	       
		 String contAddrSection3 = contactAddr2ResolverOpt.flatMap(fun -> fun.apply("adjacent")).map(str -> str.replaceAll("鄰$", StringUtils.EMPTY)).orElse(null);
		 String contAddrSection = Optional.ofNullable(add).map(address -> {
	            Function<String, Optional<String>> addressResolver = null;
				try {
					addressResolver = handleAddressResolver(address).orElseThrow(() -> new Exception());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            String result = addressResolver.apply("village").map(village -> address.replace(village, StringUtils.EMPTY)).orElse(address);
	            String result2 = addressResolver.apply("vil").map(vil -> result.replace(vil, StringUtils.EMPTY)).orElse(result);
	            return addressResolver.apply("adjacent").map(adjacent -> result2.replace(adjacent, StringUtils.EMPTY)).orElse(result2);
	        }).orElse(null);
		 
		   System.out.println(contAddrSection1);
	     System.out.println(contAddrSection2);
	     System.out.println(contAddrSection3);
	     System.out.println(contAddrSection);
	     
	}

public static Optional<Function<String, Optional<String>>> handleAddressResolver(String address) {
		// 地址解析正則
        Pattern pattern = Pattern.compile("(?<postMail>\\d+)?(?<city>\\D+?[縣市])?(?<district>\\D+?(群島|澳鎮|釣魚臺|市區|鎮區|鎮市|[鄉鎮市區]))?(?<village>.+?[村]?(村(?![里路街])))?(?<vil>.+?[里]?(里(?![路街])))?(?<adjacent>.+?(鄰))?(?<road>(?!馬路)(.+路.+街)|.+?(路街|新村|大道|[路街]))?(?<section>.+?(段))?(?<lane>.+?(巷))?(?<alley>.+?(弄))?(?<suballey>.+?(衖))?(?<others>.+)?");

        Matcher matcher = pattern.matcher(address);

        if (!matcher.find()) {
            return Optional.empty();
        }
       return  Optional.of(name -> Optional.ofNullable(matcher.group(name)));
	}

}
