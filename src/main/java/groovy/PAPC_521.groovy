package groovy

def soldToParty = "10016903"
def fullyQualifiedCustomerNumber = "0010021825_US01_02_01"
soldToParty = buildFullyQualifiedSoldToParty(soldToParty, fullyQualifiedCustomerNumber)
println(soldToParty)

def buildFullyQualifiedSoldToParty(def soldToCustomer, def fullyQualifiedCustomerParameter) {

    def fullyQualifiedSoldToCustomer = soldToCustomer

    if (fullyQualifiedSoldToCustomer.indexOf("_") == -1) {
        String salesArea = (fullyQualifiedCustomerParameter.split("_", 2))[1]
        fullyQualifiedSoldToCustomer = soldToCustomer + "_" + salesArea
    }

    fullyQualifiedSoldToCustomer=includeLeadingZeroToCustomer(fullyQualifiedSoldToCustomer)

    return fullyQualifiedSoldToCustomer
}

def includeLeadingZeroToCustomerIfRequired(def value) {
    if (!value.startsWith("00")) {
        value = "00" + value;
    }
    return value;
}